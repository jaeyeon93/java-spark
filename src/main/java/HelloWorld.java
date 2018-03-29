import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        staticFileLocation("/static");
        //(req, res)는 자바8의 람다이다. 이름없는 메소드라고 생각을 하면된다. (req, res)는 인자이다.
        get("/hello", (request, response) -> {
            return "Get Hello: " + request.queryParams("name") + " 나이는 : " + request.queryParams("age");
        });

        post("/hello", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("name", request.queryParams("name"));
            model.put("age", request.queryParams("age"));
            return render(model, "result.html");
        });


    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}