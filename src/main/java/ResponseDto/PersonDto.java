package ResponseDto;

import lombok.Data;

@Data
public class PersonDto {
    private String gender;
    private String nat;
    private NameDto name;
    private LocationDto location;


//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public NameDto getName() {
//        return name;
//    }
//    public void setName(NameDto name) {
//        this.name = name;
//    }
//
//    public LocationDto getLocation() {
//        return location;
//    }
//
//    public void setLocation(LocationDto location) {
//        this.location = location;
//    }
//
//    public String getNat() {
//        return nat;
//    }
//
//    public void setNat(String nat) {
//        this.nat = nat;
//    }
}
