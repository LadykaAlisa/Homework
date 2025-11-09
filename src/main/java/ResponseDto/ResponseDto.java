package ResponseDto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDto {
    public List<PersonDto> results;

    private InfoDto info;

//    public List<PersonDto> getResults() {
//        return results;
//    }
//    public void setResults(List<PersonDto> results) {
//        this.results = results;
//    }
}

