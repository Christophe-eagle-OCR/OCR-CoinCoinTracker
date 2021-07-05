package com.perez.christophe.coincointracker;


import com.perez.christophe.coincointracker.controller.AuthActivity;
import com.perez.christophe.coincointracker.model.Wallet;

import org.junit.Test;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WalletUnitTest {
    private String mString;

    /* exemple de @test qui est affiché lors de la création de la classe test
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    */

    //@Test
    // Given (quels sont les parametres de fonctions utilisés?)
    // When  (dans quel contexte?)
    // Then  (quel doit etre le résultat?)


    private void printLn(String string) {
        mString = string;
        System.out.println(string); // pour afficher du texte associé au @test
    }


    /* Test pour tester la methode getMontantCourant() */
    @Test
    public void createWallet() {
        // Given : créer une instance de mon porte monnaie avec 42€ en parametre
        Wallet wallet = new Wallet(42);

        // When : expected (attendu) 42€ dans le porte monnaie

        // Then :vérifier que le porte monnaie actuel contient 42€ avec getMontantCourant
        assertEquals(42, wallet.getMontantCourant(), 0.001);
    }

    /* Test pour tester la methode depot() */
    @Test
    public void depositMoney() throws Exception {
        // Given : create a new wallet instance , with 0€
        Wallet wallet = new Wallet(0);

        // When : deposit in wallet 10€
        wallet.depot(10);

        // Then : Check that the wallet actualy contains 10€
        assertEquals(10, wallet.getMontantCourant(), 0.001);
    }

    /* Test pour tester la methode retrait() */
    @Test
    public void withdrawMoney() {
        // Given : create a new wallet instance , with 30€
        Wallet wallet = new Wallet(30);

        // When : withdraw (retirer) in wallet 10€
        wallet.retrait(10);

        // Then : Check that the wallet actualy contains 20€
        assertEquals(20, wallet.getMontantCourant(), 0.001);

    }

    /* Test pour tester un interdit avec throws Exception */
    /*deposer de l'argent au dessus de la capacité maxi de 30€
     */
    @Test(expected = Exception.class)
    public void depositMoneyAboveCapacity() throws Exception {
        // Given : create a new wallet instance , with 10€
        Wallet wallet = new Wallet(10);

        // When : deposit in wallet 25€
        // Then : Put more money than possible.Should throw an exception (devrait lever une exception)
        wallet.depot(25);
        this.printLn("@Test non reussi car ne lève pas l'exception  qui est : il y a trop d'argent ! ");

    }


    /* retirer de l'argent en dessous du seuil */
    @Test
    public void withDrawMoneyBelowThreshold() {
        // Given : create a new wallet instance , with 30€
        Wallet wallet = new Wallet(30);

        // When : etreADecouvert si montant > à MontantCourant
        wallet.etreADecouvert(40);

        // Then Check that the wallet actualy contains -10€
        assertEquals(-10, wallet.getMontantCourant(), 0.001);
    }


    /*
    Pour tester le methode getUserToken  qui permet l'authentification d'un user
    qui s'identifie avec son interface telephone  et ulise donc une dependence Android
    on va utiliser Mockito pour faire un mock (soit un bouchon)
     */
    @Test
    public void testWalletContent() {
        // 1 : create a new AuthActivity instance,
        // mais le test est rouge car on n'accede pas au telephone
        //AuthActivity authActivity = new AuthActivity();
        //String token = authActivity.getUserToken();

        /* 2 : puis au lieu d'instancier la vraie  class AuthActivity ,
        je vais utiliser Mockito pour faire un "bouchon"  sur getSharedPreferences de la class AuthActivity
        et là le test passe au  vert
         */
        AuthActivity authActivity = mock(AuthActivity.class);

        when(authActivity.getUserToken()).thenReturn("fakeToken");

        String token = authActivity.getUserToken();

        // Test token...
        // imaginons que nous faisons d'autre Test un peu plus poussés....

    }
}
