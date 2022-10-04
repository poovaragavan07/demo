package details.vendors.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "vendors")
public class vendor {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
 
    @Column(name = "vendorname")
    private String vendorName;
 
    @Column(name = "vendoraddress")
    private String vendoraddress;
 
    @Column(name = "city")
    private String city;
    
    @Column(name = "companyname")
    private String companyname;
 
    public vendor(long id, String vendorName, String vendoraddress, String city, String companyname) {
		super();
		this.id = id;
		this.vendorName = vendorName;
		this.vendoraddress = vendoraddress;
		this.city = city;
		this.companyname = companyname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendoraddress() {
		return vendoraddress;
	}

	public void setVendoraddress(String vendoraddress) {
		this.vendoraddress = vendoraddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public vendor() {}

}