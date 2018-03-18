package com.newcoder.questionDemo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Steven on 18/07/2017.
 */
public class FreemarkerUtil {

        public static Template freemarker_conf() throws IOException {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_0);

        cfg.setDirectoryForTemplateLoading(new File("H:/IdeaProjects/questionDemo/src/main/resources/templates"));

        cfg.setDefaultEncoding("UTF-8");

        Template temp = cfg.getTemplate("01.ftl");

        return temp;
        }
        public static void main(String[] args) throws IOException{
                FreemarkerUtil f = new FreemarkerUtil();
                f.freemarker_conf();
                // Create the root hash. We use a Map here, but it could be a JavaBean too.
                Map<String, Object> root = new HashMap<>();

// Put string "user_said" into the root
                root.put("user", "Big Joe");

// Create the "latestProduct" hash. We use a JavaBean here, but it could be a Map too.
                Product latest = new Product();
                latest.setUrl("joker.url");
                latest.setName("green mouse");
// and put it into the root
                root.put("latestProduct", latest);

                Writer out = new OutputStreamWriter(System.out);

                try {
                        freemarker_conf().process(root,out);
                } catch (TemplateException e) {
                        e.printStackTrace();
                }
        }

}

