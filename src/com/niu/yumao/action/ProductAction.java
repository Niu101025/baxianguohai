package com.niu.yumao.action;

import com.niu.yumao.domain.Category;
import com.niu.yumao.domain.PageBean;
import com.niu.yumao.domain.Product;
import com.niu.yumao.service.CategoryService;
import com.niu.yumao.service.InfoService;
import com.niu.yumao.service.ProductService;
import com.niu.yumao.utils.ImageUtils;
import com.niu.yumao.utils.OperateImage;
import com.niu.yumao.utils.StrUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import java.awt.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductAction extends ActionSupport implements ModelDriven<Product> {

    private Product product = new Product();

    @Override
    public Product getModel() {
        // TODO Auto-generated method stub
        return product;
    }

    private ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    private CategoryService categoryService;

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    private InfoService infoService;

    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

    // myFile属性用来封装上传的文件
    private File myFile;

    // myFileContentType属性用来封装上传文件的类型
    private String myFileContentType;

    // myFileFileName属性用来封装上传文件的文件名
    private String myFileFileName;

    public File getMyFile() {
        return myFile;
    }

    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }

    public String getMyFileContentType() {
        return myFileContentType;
    }

    public void setMyFileContentType(String myFileContentType) {
        this.myFileContentType = myFileContentType;
    }

    public String getMyFileFileName() {
        return myFileFileName;
    }

    public void setMyFileFileName(String myFileFileName) {
        this.myFileFileName = myFileFileName;
    }


    private String x1;
    private String x2;
    private String y1;
    private String y2;

    public void setX2(String x2) {
        this.x2 = x2;
    }

    public void setX1(String x1) {
        this.x1 = x1;
    }

    public void setY2(String y2) {
        this.y2 = y2;
    }

    public void setY1(String y1) {
        this.y1 = y1;
    }

    /**
     * 添加产品
     *
     * @return
     */
    public String add() {

        setImg();
        product.setPtime(new Date());
        productService.add(product);
        return "saveProductSuccess";
    }

    public void setImg() {
        try {
            File toFile = null;
            if (StrUtils.isNotBlank(myFileFileName) && myFile != null) {
                // 设置目标文件
                Date date = new Date();
                DateFormat format = new SimpleDateFormat("yyyy_MM_dd");
                String day = format.format(date);
                String time = new SimpleDateFormat("HH_mm_ss").format(date);
                // 基于myFile创建一个文件输入流
                InputStream is = new FileInputStream(myFile);
                // 设置上传文件目录
                String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload") + "/" + day;
                File file = new File(uploadPath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                /**
                 * 裁剪后的图片存在的位置
                 */
                File cropFile = new File(ServletActionContext.getServletContext().getRealPath("/crop") + "/" + day);
                if (!cropFile.exists()) {
                    cropFile.mkdirs();
                }

                //先保存当前的图片
                toFile = new File(uploadPath, time + "_" + this.getMyFileFileName());
                // 创建一个输出流
                OutputStream os = null;
                // 设置缓存
                byte[] buffer = new byte[1024];
                int length = 0;
                os = new FileOutputStream(toFile);
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                is.close();
                // 关闭输出流
                os.close();
                if (toFile != null) {
                    //开始裁剪
                    if (StringUtils.isNotBlank(x1) || StringUtils.isNotBlank(x2)
                            || StringUtils.isNotBlank(y1) || StringUtils.isNotBlank(y2)) {
                        int x = (int) Float.parseFloat(x1);
                        int y = (int) Float.parseFloat(y1);
                        int xx = (int) Float.parseFloat(x2);
                        int yy = (int) Float.parseFloat(y2);
                        int w = xx - x;
                        int h = yy - y;
                        OperateImage image = new OperateImage(ServletActionContext.getServletContext().getRealPath("/crop") + "/" + day + "/" + toFile.getName(), toFile.getAbsolutePath(), x, y, w, h,
                                infoService.findInfo().getWebsitename());
                        image.cut();
                        product.setPimg("/crop/" + day + "/" + toFile.getName());
                        toFile.delete();
                    } else {
                        String watername = infoService.findInfo().getWebsitename();
                        if (StrUtils.isNotBlank(watername)) {
                            ImageUtils.pressText(toFile.getAbsolutePath(), watername, "宋体", Font.BOLD, 20, Color.red, -1, -1, 0.5f);
                        }
                        product.setPimg("/upload/" + day + "/" + toFile.getName());
                    }


                }

            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();

        }
    }

    private Integer currPage = 1;

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public String findAllProduct() {
        PageBean<Product> pageBean = productService.findByPage(currPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAllProductSuccess";
    }

    public String findAll() {
        PageBean<Product> pageBean = productService.findByPage(currPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAllSuccess";
    }

    public String edit() {
        List<Category> categories = categoryService.findAllCategory();
        PageBean<Category> pageBean = new PageBean<Category>();
        pageBean.setList(categories);
        ActionContext.getContext().getValueStack().push(pageBean);
        Product mProduct = productService.findById(product.getPid());
        ActionContext.getContext().getValueStack().push(mProduct);
        return "editProductSuccess";
    }


    public String save() {
        setImg();
        productService.save(product);
        return "saveSuccess";
    }

    public String delete() {
        File file = new File(ServletActionContext.getServletContext().getRealPath("/") + productService.findProductById(product.getPid()).getPimg());
        if (file != null && file.exists()) {
            file.delete();
        }
        productService.deleteProduct(product);
        return "deleteSuccess";
    }
}
