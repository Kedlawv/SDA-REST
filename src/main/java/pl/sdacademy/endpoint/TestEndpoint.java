package pl.sdacademy.endpoint;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestEndpoint {

    @RequestMapping(method = RequestMethod.GET)
    public String testResult(@RequestParam("imie") String name) {
        return "okej to ja " + name;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String zapisz(@RequestParam("imie") String imie,
                         @RequestParam("nazwisko") String nazwisko) {

        return "Witaj " + imie + " " + nazwisko;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() {
        return "info o aplikacji";
    }

    @RequestMapping(value = "/imie/{fraza}", method = RequestMethod.GET)
    public String infoImie(@PathVariable("fraza") String fraza) {
        return "wypiszemy tu wszystko dla " + fraza;
    }
}
