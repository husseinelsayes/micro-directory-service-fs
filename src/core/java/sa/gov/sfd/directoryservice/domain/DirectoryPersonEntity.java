package sa.gov.sfd.directoryservice.domain;

import javax.naming.Name;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry(objectClasses = { "person", "top" })
public class DirectoryPersonEntity {

	@Id
	@JsonIgnore
	private Name dn;
	
	@Attribute(name = "displayName")
	private String fullNameEn;
	
	//@JsonIgnore
	@Attribute(name = "description")
	private String fullNameAr;
	
	//@Attribute(name = "telephoneNumber")
	@Attribute(name = "ciscoEcsbuTransferId")
	private String ipPhone;

	@Attribute(name="title")
	private String jobTitle;

	@Attribute(name="mail")
	private String email;

	@Attribute(name="jpegPhoto")
	private byte[] image;


	public DirectoryPersonEntity() {

	}

	


	public Name getDn() {
		return dn;
	}

	public void setDn(Name dn) {
		this.dn = dn;
	}

	public String getFullNameEn() {
		return fullNameEn;
	}

	public void setFullNameEn(String fullNameEn) {
		this.fullNameEn = fullNameEn;
	}

	public String getFullNameAr() {
		return fullNameAr;
	}

	public void setFullNameAr(String fullNameAr) {
		this.fullNameAr = fullNameAr;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "DirectoryPersonEntity [dn=" + dn + ", email=" + email + ", fullNameAr=" + fullNameAr + ", fullNameEn="
				+ fullNameEn + ", ipPhone=" + ipPhone + ", jobTitle=" + jobTitle + "]";
	}


}
