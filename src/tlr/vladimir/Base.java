package tlr.vladimir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;

public class Base {

    String creaty = "" + "CREATE TABLE Questions\n" + "(\n" + "id integer NOT NULL,\n" + "Ques text,\n"
            + "CONSTRAINT PK_Questions PRIMARY KEY (id)\n" + ");" + "\n" + "CREATE TABLE Answer\n" + "(\n"
            + "id integer NOT NULL,\n" + "Prog text,\n" + "Answ text,\n" + "CONSTRAINT PK_Answer PRIMARY KEY (id)\n"
            + ");\n" + "CREATE TABLE `Links` (\n" + "\t`id` INT NOT NULL AUTO_INCREMENT,\n" + "\t`Prog` TEXT,\n"
            + "\t`Link` TEXT,\n" + "\tPRIMARY KEY (`id`)\n" + ");";

    static final String DB_URL = "jdbc:h2:./db/Base";
    static final String DB_Driver = "org.h2.Driver";

    Base(boolean exist) {
        if (!exist)
            try {
                Class.forName(DB_Driver);
                Connection connection = DriverManager.getConnection(DB_URL);
                Statement stmt = connection.createStatement();
                stmt.execute(creaty);
                stmt.execute("INSERT INTO Questions VALUES (1, 'Ваша ос?');");
                stmt.execute("INSERT INTO Questions VALUES (2, 'Вам нужна онлайн программа?');");
                stmt.execute("INSERT INTO Questions VALUES (3, 'Вы рассматриваете только бесплатные варианты?');");
                stmt.execute("INSERT INTO Questions VALUES (4, 'Вам нужно форматирование текста?');");
                stmt.execute("INSERT INTO Questions VALUES (5, 'Вам нужны дополнительные материалы<br>(картинки и т.п.) в документе?');");
                stmt.execute("INSERT INTO Questions VALUES (6, 'Вам нужна статистика по тексту?');");
                stmt.execute("INSERT INTO Questions VALUES (7, 'Вам важна скорость работы?');");

                stmt.execute("INSERT INTO Answer VALUES (1, 'Блокнот windows', '3NYNNNY');");
                stmt.execute("INSERT INTO Answer VALUES (2, 'jEdit', '3NYNNNY');");
                stmt.execute("INSERT INTO Answer VALUES (3, 'OpenOffice', '3NYYYYN');");
                stmt.execute("INSERT INTO Answer VALUES (4, 'Sublime Text', '3NYNNYN');");
                stmt.execute("INSERT INTO Answer VALUES (5, 'AbiWord', '3NYYYYN');");
                stmt.execute("INSERT INTO Answer VALUES (6, 'LibreOffice', '3NYYYYN');");
                stmt.execute("INSERT INTO Answer VALUES (7, 'Rnote', '3NYYYNY');");
                stmt.execute("INSERT INTO Answer VALUES (8, 'Microsoft Word', '3NNYYYN');");
                stmt.execute("INSERT INTO Answer VALUES (9, 'Microsoft Word онлайн', '3YYYYNN');");
                stmt.execute("INSERT INTO Answer VALUES (10, 'Microsoft Word', '4NNYYYN');");
                stmt.execute("INSERT INTO Answer VALUES (11, 'Microsoft Word', '6NNYYYN');");
                stmt.execute("INSERT INTO Answer VALUES (12, 'Microsoft Word', '7NNYYYN');");
                stmt.execute("INSERT INTO Answer VALUES (13, 'Google Документы', '3NYYYYY');");
                stmt.execute("INSERT INTO Answer VALUES (14, 'Google Документы', '7NYYYYY');");
                stmt.execute("INSERT INTO Answer VALUES (15, 'Google Документы', '6NYYYYY');");
                stmt.execute("INSERT INTO Answer VALUES (16, 'Google Документы', '4NYYYYY');");
                stmt.execute("INSERT INTO Answer VALUES (17, 'Google Документы онлайн', '3YYYYYY');");
                stmt.execute("INSERT INTO Answer VALUES (18, 'iA Writer', '4NNYYYN');");
                stmt.execute("INSERT INTO Answer VALUES (19, 'iA Writer', '3NNYYYN');");
                stmt.execute("INSERT INTO Answer VALUES (20, 'iA Writer', '6NYYYYN');");
                stmt.execute("INSERT INTO Answer VALUES (21, 'iA Writer', '7NNYYYN');");
                stmt.execute("INSERT INTO Answer VALUES (22, 'Notebooks', '3NNYYYN');");
                stmt.execute("INSERT INTO Answer VALUES (23, 'Notebooks', '7NNYYYN');");
                stmt.execute("INSERT INTO Answer VALUES (24, 'Notebooks', '4NNYYYN');");
                stmt.execute("INSERT INTO Answer VALUES (25, 'FocusWriter', '3NYYNYN');");
                stmt.execute("INSERT INTO Answer VALUES (26, 'FocusWriter', '4NYYNYN');");
                stmt.execute("INSERT INTO Answer VALUES (27, 'FocusWriter', '5NYYNYN');");
                stmt.execute("INSERT INTO Answer VALUES (28, 'Final Draft', '3NNYYYY');");
                stmt.execute("INSERT INTO Answer VALUES (29, 'Final Draft', '4NNYYYY');");
                stmt.execute("INSERT INTO Answer VALUES (30, 'Final Draft', '7NNYYYY');");
                stmt.execute("INSERT INTO Answer VALUES (31, 'Scrivener', '3NNYYYN');");
                stmt.execute("INSERT INTO Answer VALUES (32, 'Scrivener', '4NNYYYN');");
                stmt.execute("INSERT INTO Answer VALUES (33, 'Scrivener', '7NNYYYN');");
                stmt.execute("INSERT INTO Answer VALUES (34, 'Emacs', '5NYNNYY');");
                stmt.execute("INSERT INTO Answer VALUES (35, 'Emacs', '3NYNNYY');");
                stmt.execute("INSERT INTO Answer VALUES (36, 'Fb2edit', '5NYYYYY');");

                stmt.execute("INSERT INTO Links VALUES (1, 'Блокнот windows', 'https://www.microsoft.com/en-us/p/notepad-for-windows-10/9nblggh4w20k?activetab=pivot:overviewtab');");
                stmt.execute("INSERT INTO Links VALUES (2, 'jEdit', 'http://www.jedit.org/index.php?page=download');");
                stmt.execute("INSERT INTO Links VALUES (3, 'OpenOffice', 'https://www.openoffice.org/ru/download/index.html');");
                stmt.execute("INSERT INTO Links VALUES (4, 'Sublime Text', 'http://www.sublimetext.com/');");
                stmt.execute("INSERT INTO Links VALUES (5, 'AbiWord', 'https://abisource.com/download/');");
                stmt.execute("INSERT INTO Links VALUES (6, 'LibreOffice', 'https://www.libreoffice.org/download/download/?lang=ru');");
                stmt.execute("INSERT INTO Links VALUES (7, 'Rnote', 'https://rnote.do.am/');");
                stmt.execute("INSERT INTO Links VALUES (9, 'Microsoft Word онлайн', 'https://office.live.com/start/Word.aspx');");
                stmt.execute("INSERT INTO Links VALUES (10, 'Microsoft Word', 'https://www.microsoft.com/ru-ru/microsoft-365/word');");
                stmt.execute("INSERT INTO Links VALUES (11, 'Google Документы', 'https://google-docs.softonic.ru/');");
                stmt.execute("INSERT INTO Links VALUES (12, 'Google Документы онлайн', 'https://docs.google.com/document/u/0/');");
                stmt.execute("INSERT INTO Links VALUES (13, 'iA Writer', 'https://ia.net/downloads');");
                stmt.execute("INSERT INTO Links VALUES (14, 'Notebooks', 'https://www.notebooksapp.com/download/');");
                stmt.execute("INSERT INTO Links VALUES (15, 'FocusWriter', 'https://gottcode.org/focuswriter/');");
                stmt.execute("INSERT INTO Links VALUES (16, 'Final Draft', 'https://www.finaldraft.com/');");
                stmt.execute("INSERT INTO Links VALUES (17, 'Scrivener', 'http://scrivenersoft.ru/');");
                stmt.execute("INSERT INTO Links VALUES (18, 'Emacs', 'https://www.gnu.org/software/emacs/');");
                stmt.execute("INSERT INTO Links VALUES (19, 'Fb2edit', 'http://fb2edit.lintest.ru/');");
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }


    public ArrayList<String> getQuestions() {
        ArrayList<String> out = new ArrayList<>();
        try {
            Class.forName(DB_Driver);
            Connection connection = DriverManager.getConnection(DB_URL);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Questions");
            while (rs.next()) {
                out.add(rs.getString("Ques"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }

    public ArrayList<String> getProg(String text) {
        ArrayList<String> out1 = new ArrayList<>();
        ArrayList<String> out2 = new ArrayList<>();
        try {
            Class.forName(DB_Driver);
            Connection connection = DriverManager.getConnection(DB_URL);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Answer");
            while (rs.next()) {
                out1.add(rs.getString("answ"));
                out2.add(rs.getString("Prog"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<String> g = new ArrayList<>();
        int max = 0;


        for (String s : out1) {
            if (compare(text, s) >= max) {
                max = compare(text, s);
            }
        }

        for (int i = 0; i < out1.size(); i++) {
            if(compare(text, out1.get(i)) == max){
                g.add(out2.get(i));
            }
        }

        return g;
    }

    private int compare(String text, String o) {
        char[] a = text.toCharArray();
        char[] b = o.toCharArray();
        if(a[0] != b[0] && b[1] != 'Y')
            return 0;
        if(a[1] == 'Y' && b[1] != 'Y')
            return 0;
        int out = 0;
        for (int i = 2; i < text.length(); i++) {
            if(a[i] == b[i]){
                out++;
            }
        }
        return out;
    }

    public String getLink(String d) {
        try {
            Class.forName(DB_Driver);
            Connection connection = DriverManager.getConnection(DB_URL);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Links");
            while (rs.next()) {
                if(d.equals(rs.getString("Prog")))
                    return rs.getString("Link");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
