package ResponseDto;

import lombok.Data;

@Data
public class LocationDto {
    private StreetDto street;
    private CoordinatesDto coordinates;
    private TimezoneDto timezone;
    private InfoDto info;
    private String city;
    private String state;
    private String country;
    private Object postcode;


//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry (String country) {
//        this.country = country;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity (String city) {
//        this.city = city;
//    }
}
