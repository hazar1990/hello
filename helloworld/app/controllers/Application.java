package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import play.data.validation.Constraints.*;

import java.util.*;

import views.html.*;

public class Application extends Controller {
    
    /**
     * Describes the hello form.
     */
    public static class Hello {
        @Required public  String a;
        @Required public String b;
        @Required public String c;
        
        public String color;
    } 
    
    // -- Actions
  
    /**
     * Home page
     */
    public static Result index() {
        return ok(
            index.render(form(Hello.class))
        );
    }
  
    /**
     * Handles the form submission.
     */
    public static Result sayHello() {
        Form<Hello> form = form(Hello.class).bindFromRequest();
        if(form.hasErrors()) {
            return badRequest(index.render(form));
        } else 
        {
            Hello data = form.get();
            
            Integer aa=new Integer(Integer.valueOf(data.a));
            Integer bb=new Integer(Integer.valueOf(data.b));
            Integer cc=new Integer(Integer.valueOf(data.c));
            int aaa=aa.intValue();
            int bbb=bb.intValue();
            int ccc=cc.intValue();
            String eq="the problem is"+aaa+"x^2 +"+bbb+"x +"+ccc+"=0";
            double dlta=(bbb*bbb)-4*aaa*ccc;
            String message="";
            if(dlta>0)
            {
            	int x1=(int) ((-bbb-Math.sqrt(dlta))/2*aaa);
            	int x2=(int) ((-bbb+Math.sqrt(dlta))/2*aaa);
            message="there is two answers "+x1+" and "+x2;
            }
            if(dlta==0)
            {
            	int x=-bbb/2*aaa;
            	message="there is one answer "+x ;
            }
            if(dlta<0)
            {
            	message="there is no answers";
            }
            return ok(
                hello.render(eq,message, data.color)
            );
        }
    }
  
}