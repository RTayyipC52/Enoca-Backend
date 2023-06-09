package web.project.entities.concretes;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private int companyId;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "number_of_employees")
	private int numberOfEmployees;
	
	@JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Employee> employees;
}

