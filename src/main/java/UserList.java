import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class UserList {
    public static void main(String[] args) {
        staticFileLocation("/static");
        List<User> users = new ArrayList<>();
        post("/users", (request, response) -> {
            User user = new User();
            user.setAge(request.queryParams("name"));
            user.setAge(request.queryParams("age"));
            users.add(user);
            Map<String, Object> model = new HashMap<>();
            model.put("users", users);
            return render(model, "result.html");
        });


    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}