package myPackage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.time.LocalDateTime;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Part;


@ManagedBean(name = "postit")
@SessionScoped
public class PostIt {

    String pwd;
    public String fileUrl;
    public String fileName;
    public int fileSize;
    Part uploadedFile;
    boolean show = false;
    String uploadedFileUrl;
    

    DbProcessor bp;

    public void upload(ActionEvent e) throws IOException, Exception {
        if (uploadedFile == null) {
            throw new Exception("soubor nevybran");
        }
        bp = new DbProcessor();
        fileName = uploadedFile.getSubmittedFileName();
        InputStream is = uploadedFile.getInputStream();
        File file = new File(File.createTempFile("upload", "").getPath());
        Files.copy(is, file.toPath(), REPLACE_EXISTING);

        fileUrl = file.getAbsolutePath();
        int id = bp.insert(fileUrl, pwd);
        System.out.println("URL to your file is: " + uploadedFileUrl + id);
        
        uploadedFileUrl = "http://localhost:8080/DMS/downloadFile.xhtml?id=" + id;
        show = true;
    }

    
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean getShow() {
        return show;
    }

    public String getUploadedFileUrl() {
        return uploadedFileUrl;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public void setUploadedFileUrl(String uploadedFileUrl) {
        this.uploadedFileUrl = uploadedFileUrl;
    }

}
