package directoryDeliveryMechanism.view;

public class DirectoryPersonDTO {
    private String name_ar;
    private String name_en;
    private String email;
    private String ipPhone;
    private String jobTitle;
    private byte[] image;

    public String getName_ar() {
        return name_ar;
    }

    public void setName_ar(String name_ar) {
        this.name_ar = name_ar;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIpPhone() {
        return ipPhone;
    }

    public void setIpPhone(String ipPhone) {
        this.ipPhone = ipPhone;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public DirectoryPersonDTO(String name_ar, String name_en, String email, String ipPhone, String jobTitle,
            byte[] image) {
        this.name_ar = name_ar;
        this.name_en = name_en;
        this.email = email;
        this.ipPhone = ipPhone;
        this.jobTitle = jobTitle;
        this.image = image;
    }





    
}