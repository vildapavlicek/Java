
package myPackage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean(name = "downloadit")
@SessionScoped
public class DownloadIt {
    String fileUri;
    int id;
    String pwd;

    public String getFileUri() {
        return fileUri;
    }

    public int getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setFileUri(String fileUri) {
        this.fileUri = fileUri;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
 
    
    
    
}
