package commands;

import managing.NoArgsCommand;
import managing.PointCommand;
import managing.Vars;
import stored.Worker;

import java.io.File;
import java.io.FileOutputStream;

@PointCommand(name="save", description = "сохранить коллекцию в файл")
public class CommandSave extends NoArgsCommand {
    public CommandSave(String msg) {
        super(msg);
    }

    public CommandSave() {
        super();
    }

    private String getStr() {
        String res = "";
        for (Worker it : Vars.curCol.getCollection()) {
            String a = "", b = "", c = "", d = "", e = "", f = "", g = "", h = "", i = "", j = "", pos = "";
            a = it.getId().toString();
            if (it.getName() != null)
                b = it.getName();
            if (it.getCoordinates().getX() != null)
                c = it.getCoordinates().getX().toString();
            if (it.getCoordinates().getY() != null)
                d = it.getCoordinates().getY().toString();
            if (it.getCreationDate() != null)
                e = it.getCreationDate().toString();
            if (it.getStartDate() != null)
                f = it.getStartDate().toString();
            if (it.getStatus() != null)
                g = it.getStatus().name();
            if (it.getPerson().getEyeColor() != null)
                h = it.getPerson().getEyeColor().name();
            if (it.getPosition() != null)
                pos = it.getPosition();
            if (it.getPerson().getHairColor() != null)
                i = it.getPerson().getHairColor().name();
            if (it.getPerson().getNationality() != null)
                j = it.getPerson().getNationality().name();

            res += a + "," + b + "," + c + "," +
                    d + "," + e + "," +
                    it.getSalary() + "," + f + "," + pos + "," + g + "," +
                    it.getPerson().getWeight() + "," + h + "," +
                    i + "," + j + "\n";
        }
        return res;
    }

    @Override
    public void execute() {
        String data = "id,name,coordinates/x,coordinates/y,creationDate,salary," +
                "startDate,position,status,person/weight,person/eyeColor,person/hairColor,person/nationality\n";
        String path = Vars.saveFile;
        try {
            String str = this.getStr();
            FileOutputStream out = new FileOutputStream(path);
            byte[] strToBytes1 = data.getBytes();
            byte[] strToBytes2 = str.getBytes();
            out.write(strToBytes1);
            out.write(strToBytes2);
            out.close();
            System.out.println("Data saved to " + Vars.saveFile);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't work with file");
        }
    }
}
