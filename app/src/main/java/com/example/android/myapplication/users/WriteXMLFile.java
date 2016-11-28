package com.example.android.myapplication.users;

/**
 * Created by peter on 2016-11-05.
 */

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriteXMLFile {

    private final Context context;

    public WriteXMLFile(Context context) {
    this.context = context;
    }


    public void main(String argv[]) {


        //writeToFile("hello world", this.context);
      //  try {

            String filename = "myfileabc.txt";
            String string = "Hello world!";
            FileOutputStream outputStream;
            FileInputStream inputStream;

            try {

                File file = new File(context.getFilesDir(), filename);

                outputStream = this.context.openFileOutput(filename, Context.MODE_APPEND);
                outputStream.write(string.getBytes());
                outputStream.close();

               /* inputStream = new FileInputStream(filename);

                String everything = inputStream.toString();//IOUtils.toString(inputStream);

                inputStream.close();
*/
            } catch (Exception e) {
                e.printStackTrace();
            }

         /*   DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("company");
            doc.appendChild(rootElement);

            // staff elements
            Element staff = doc.createElement("Staff");
            rootElement.appendChild(staff);

            // set attribute to staff element
            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            staff.setAttributeNode(attr);

            // shorten way
            // staff.setAttribute("id", "1");

            // firstname elements
            Element firstname = doc.createElement("firstname");
            firstname.appendChild(doc.createTextNode("yong"));
            staff.appendChild(firstname);

            // lastname elements
            Element lastname = doc.createElement("lastname");
            lastname.appendChild(doc.createTextNode("mook kim"));
            staff.appendChild(lastname);

            // nickname elements
            Element nickname = doc.createElement("nickname");
            nickname.appendChild(doc.createTextNode("mkyong"));
            staff.appendChild(nickname);

            // salary elements
            Element salary = doc.createElement("salary");
            salary.appendChild(doc.createTextNode("100000"));
            staff.appendChild(salary);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            File file = Environment.getDataDirectory();

            String fileLoc = file.getPath() + "\file.xml";

            StreamResult result = new StreamResult(fileLoc);

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }*/
    }

    private void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config_abc.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            //Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
