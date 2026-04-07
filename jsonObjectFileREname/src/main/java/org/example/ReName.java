package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.example.Main.FILE_PATH;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ReName {
    public static void doUpdate() {

        try {

            // Reading
            FileReader reader=new FileReader(FILE_PATH);
            JsonObject jsonObject=JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();

            // change name inside department array , teams array which inside department, members array inside teams array

            if(jsonObject.has("departments")){
                jsonObject.getAsJsonArray("departments").forEach(deptName->{
                    JsonObject department=deptName.getAsJsonObject();

                    if(department.has("name")){
                        department.addProperty("name","IT's");
                    }


                    if(department.has("teams")){
                        department.getAsJsonArray("teams").forEach(teamName->{
                            JsonObject team=teamName.getAsJsonObject();

                            if(team.has("name")){
                                team.addProperty("name","Corporates");
                            }

                            if(team.has("members")){
                                team.getAsJsonArray("members").forEach(memberName->{
                                    JsonObject member=memberName.getAsJsonObject();


                                    if(member.has("name")){
                                        member.addProperty("name","Java Developers");
                                    }
                                });
                            }
                        });
                    }


                });
            }

            if(jsonObject.has("projects")){
                jsonObject.getAsJsonArray("projects").forEach(projectName->{
                            JsonObject project=projectName.getAsJsonObject();

                            if(project.has("name"))
                                project.addProperty("name","Python Devs");

                        }
                );
            }

            FileWriter writer=new FileWriter(FILE_PATH);
            writer.write(jsonObject.toString());
            writer.flush();
            writer.close();

        }catch (IOException e) {
            throw new RuntimeException(e);
        }

   }
}
