/*MIT License

Copyright (c) 2018 Milena dos Santos Macedo, Carlos André Cordeiro da Silva, 
Adrielly Calado Sales, Luciano Campos de Lima Júnior.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package br.edu.ifpe.controller.md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Milena Macedo <milenasantosmcd@gmail.com>
 */
public class CriptografiaMD5 {

    public static String md5(String senha) {

        String md5 = null;
        String concatena = "m+}{}{RADOM!!@@#$%%&¨&**mmmm";

        if (senha == null) {
            return null;
        }

        try {
            senha += concatena;

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.update(senha.getBytes(), 0, senha.length());

            md5 = new BigInteger(1, messageDigest.digest()).toString(16);

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }

        return md5;
    }
}
