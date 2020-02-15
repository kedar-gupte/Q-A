package Design;

public class Read4 {

    int i = 0, size = 0, index = 0;
    char[] readBuffer = new char[4];

    public int read(char[] buf, int n) {

        i = 0;

        while(i < n) {

            if(size == 0) {
                size = read4(readBuffer);
                index = 0;
                if(size == 0)
                    break;
            } else {
                buf[i] = readBuffer[index];
                index++;
                i++;
                size--;
            }


        }

        return i;

    }

    Integer read4(char[] buffer) {
        return null;
    }

}
