package project.bots.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String city;

    private String message;

    public Cities(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Cities(String city, String message) {
        this.city = city;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
