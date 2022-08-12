package Controller.Operation;

public class ByteConverter {

    /***
     * convert Byte to kilobyte
     * @param numByte value of byte
     * @return kilobyte
     */
    long byte2KB(long numByte){
        return numByte/1024;
    }

    /***
     * convert Byte to Megabyte
     * @param numByte value of byte
     * @return Megabyte
     */
    long byte2MB(long numByte){
        return numByte/ (long) Math.pow(1024,2);
    }

    /***
     * convert Byte to gigabyte
     * @param numByte value of byte
     * @return gigabyte
     */
    long byte2GB(long numByte){
        return numByte/ (long) Math.pow(1024,3);
    }

    /***
     * byte to terabyte
     * @param numByte value of byte
     * @return terabyte
     */
    long byte2TB(long numByte){
        return numByte/ (long) Math.pow(1024,4);
    }

    /***
     * byte to petabyte
     * @param numByte value of byte
     * @return petabyte
     */
    long byte2PB (long numByte){
        return numByte / (long) Math.pow(1024,5);
    }

    /***
     * kilobyte to byte
     * @param kilobyte value of byte
     * @return byte
     */
    long kb2Byte(long kilobyte){
        return kilobyte*1024;
    }

    /***
     * kilobyte to megabyte
     * @param kilobyte value of kilobyte
     * @return megabyte
     */
    long kb2MB(long kilobyte){
        return kilobyte*1024;
    }

    /***
     * kilobyte to gigabyte
     * @param kilobyte value of kilobyte
     * @return gigabyte
     */
    long kb2GB(long kilobyte){
        return kilobyte/ (long) Math.pow(1024,2);
    }

    /***
     * kilobyte to terabyte
     * @param kilobyte value of kilobyte
     * @return gigabyte
     */
    long kb2TB(long kilobyte){
        return kilobyte/ (long) Math.pow(1024,3);
    }

    /***
     * kilobyte to petabyte
     * @param kilobyte value of kilobyte
     * @return petabyte
     */
    long kb2PB (long kilobyte){
        return kilobyte / (long) Math.pow(1024,4);
    }

    /***
     * megabyte to byte
     * @param megabyte value of megabyte
     * @return byte
     */
   long mb2Byte(long megabyte){
        return megabyte * (long) Math.pow(1024,2);
   }

    /***
     * megabyte to kilobyte
     * @param megabyte value of megabyte
     * @return kilobyte
     */
    long mb2KB(long megabyte){
        return megabyte * 1024;
    }

    /***
     * megabyte to gigabyte
     * @param megabyte value of megabyte
     * @return gigabyte
     */
    long mb2GB(long megabyte){
        return megabyte / 1024;
    }

    /***
     * megabyte to terabyte
     * @param megabyte value of megabyte
     * @return terabyte
     */
    long mb2TB(long megabyte){
        return megabyte / (long) Math.pow(1024,2);
    }

    /***
     * megabyte to petabyte
     * @param megabyte value of megabyte
     * @return petabyte
     */
    long mb2PB(long megabyte){
        return megabyte / (long) Math.pow(1024,3);
    }

    /***
     * gigabyte to byte
     * @param gigabyte value of gigabyte
     * @return byte
     */
    long gb2Byte(long gigabyte){
        return gigabyte * (long) Math.pow(1024,3);
    }

    /***
     * gigabyte to kilobyte
     * @param gigabyte value of gigabyte
     * @return kilobyte
     */
    long gb2KB(long gigabyte){
        return gigabyte * (long) Math.pow(1024,2);
    }

    /***
     * gigabyte to megabyte
     * @param gigabyte value of gigabyte
     * @return megabyte
     */
    long gb2MB(long gigabyte){
        return gigabyte * 1024;
    }

    /***
     * gigabyte to terabyte
     * @param gigabyte value of terabyte
     * @return terabyte
     */
    long gb2TB(long gigabyte){
        return gigabyte / 1024;
    }

    /***
     * gigabyte to petabyte
     * @param gigabyte value of gigabyte
     * @return petabyte
     */
    long gb2PB(long gigabyte){
        return gigabyte / (long) Math.pow(1024,2);
    }

    /***
     * terabyte to byte
     * @param terabyte value of terabyte
     * @return byte
     */
    long tb2Byte(long terabyte){
        return terabyte * (long) Math.pow(1024,4);
    }

    /***
     * terabyte to kilobyte
     * @param terabyte value of terabyte
     * @return kilobyte
     */
    long tb2KB(long terabyte){
        return terabyte * (long) Math.pow(1024,3);
    }

    /***
     * terabyte to megabyte
     * @param terabyte value of terabyte
     * @return megabyte
     */
    long tb2MB(long terabyte){
        return terabyte * (long) Math.pow(1024,2);
    }

    /***
     * terabyte to gigabyte
     * @param terabyte value of terabyte
     * @return gigabyte
     */
    long tb2GB(long terabyte){
        return terabyte * (long) Math.pow(1024,1);
    }

    /***
     * terabyte to petabyte
     * @param terabyte value of terabyte
     * @return petabyte
     */
    long tb2PB(long terabyte){
        return terabyte / 1024;
    }

    /***
     * petabyte to byte
     * @param terabyte value of petabyte
     * @return byte
     */
    long pb2Byte(long terabyte){
        return terabyte * (long) Math.pow(1024,5);
    }

    /***
     * petabyte to kilobyte
     * @param terabyte value of petabyte
     * @return kilobyte
     */
    long pb2KB(long terabyte){
        return terabyte * (long) Math.pow(1024,4);
    }

    /***
     * petabyte to megabyte
     * @param terabyte value of petabyte
     * @return megabyte
     */
    long pb2MB(long terabyte){
        return terabyte * (long) Math.pow(1024,3);
    }

    /***
     * petabyte to gigabyte
     * @param terabyte value of petabyte
     * @return gigabyte
     */
    long pb2GB(long terabyte){
        return terabyte * (long) Math.pow(1024,2);
    }

    /***
     * petabyte to terabyte
     * @param terabyte value of petabyte
     * @return terabyte
     */
    long pb2TB(long terabyte){
        return terabyte * 1024;
    }


}
