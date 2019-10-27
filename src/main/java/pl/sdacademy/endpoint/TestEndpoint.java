package pl.sdacademy.endpoint;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestEndpoint {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "hello !!!";
    }

    @RequestMapping(value = "/imie", method = RequestMethod.GET)
    public String testResult(@RequestParam("imie") String name) {
        return "okej to ja " + name;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String zapisz(@RequestParam("imie") String imie,
                         @RequestParam("nazwisko") String nazwisko,
                         @RequestBody String body) {

        return "Witaj " + imie + " " + nazwisko + " body: " + body ;
    }

    @RequestMapping(value = "/imie/{fraza}", method = RequestMethod.GET)
    public String infoImie(@PathVariable("fraza") String fraza) {
        return "wypiszemy tu wszystko dla " + fraza;
    }
}
