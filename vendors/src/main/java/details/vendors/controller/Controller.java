package details.vendors.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import details.vendors.model.vendor;
import details.vendors.controller.ResourceNotFoundException;
import details.vendors.repository.vendorrepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/vendors")
public class Controller {



   @Autowired
    private vendorrepository userRepository;



   // get all users
    @GetMapping
    public List < vendor > getAllUsers() {
        return this.userRepository.findAll();
    }



   // get user by id
    @GetMapping("/get/{id}")
    public vendor getUserById(@PathVariable(value = "id") long userId) {
        return this.userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("vendor not found with id :" + userId));
    }



   // create user
    @PostMapping
    public vendor createUser(@RequestBody vendor user) {
        return this.userRepository.save(user);
    }



   // update user
    @PutMapping("/put/{id}")
    public vendor updateUser(@RequestBody vendor user, @PathVariable("id") long userId) {
    	vendor existingUser = this.userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("vendor not found with id :" + userId));
        existingUser.setVendorName(user.getVendorName());
        existingUser.setVendoraddress(user.getVendoraddress());
        existingUser.setCity(user.getCity());
        existingUser.setCompanyname(user.getCompanyname());
        return this.userRepository.save(existingUser);
    }



   // delete user by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity < vendor > deleteUser(@PathVariable("id") long userId) {
    	vendor existingUser = this.userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
        this.userRepository.delete(existingUser);
        return ResponseEntity.ok().build();
    }
}