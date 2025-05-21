

#include <iostream>
using namespace std;

//Escribe todo el codigo en el metodo main. Utiliza variables globales para los datos del heroe y el enemigo. 
// Puedes reudar el codigo del videojuego creado en el modulo de programacion

//creamos las variable globales fuera del main. 
//El int genera el numero entero y la variable que contendra los datos de nuestros jugadores

int vidaHeroe = 100;
int vidaEnemigo = 100;
int ataqueHeroe = 20;
int ataqueEnemigo = 15;

int main() {
    cout << "Iniciamos el combate" << endl; // con el cout ingresamos el texto que se imprimira en pantalla y el endl es un salto de linea
    
    //Creamos el bucle while para inicializar el juego hasta que uno de los protagonistas se quede sin vida
    while (vidaHeroe > 0 && vidaEnemigo > 0) {//el bucle inicia con la vida de ambos mayor a 0, si en caso uno de los 2 queda con la vida menor a 0 se termina el juego (el bucle)
       
        //Iniciamos con el ataque de nuestro heroe
        int dañoHeroe = ataqueHeroe; //creamos la variable dañoHeroe para guardar la cantidad de daño que hara nuestro heroe al enemigo
        vidaEnemigo -= dañoHeroe; //en la variable de vidaEnemigo le colocamos un - antes del = y colocamos la variable que contendra la cantidad de vida que le bajara el heroe al enemigo 

        //Ingresamos el mensaje del ataque del heroe <<"mensaje"<<variable dañoHeroe (cantidad de daño que causa el heroe)
        //En el segundo ingresamos el mensaje de vida del enemigo <<"texto"<< y la variable vidaEnemigo<< para ver que cantidad de daño le causo el heroe
        cout << "El heroe ataca y causa " << dañoHeroe << " daño " << endl;
        cout << "Vida del enemigo: " << vidaEnemigo << endl;

        //creamos un if para ver si el enemigo le queda vida o no
        if (vidaEnemigo <= 0) { //si el enemigo tiene menor o igual a 0 se termina el juego, caso contrario el juego continua y el enemigo ataca.
            cout << "El heroe ha derrotado al enemigo" << endl;
            break;
        }

        //Turno del enemigo en caso siga con vida mayor a 0
        int dañoEnemigo = ataqueEnemigo; //creamos la variable dañoEnemigo para guardar los datos del ataque, en este caso la cantidad esta predeterminada en las variables globales. Entonces el dañoEnemigo seria 15
        vidaHeroe -= dañoEnemigo; //la variable vidaHeroe tiene un valor predeterminado en las variables globales el cual disminuira con el ataque que genera el enemigo. vidaHeroe(100) -= dañoEnemigo (15) 100-15 igual daño

        //Ingresamos el mensaje
        cout << "El enemigo ataca a nuestro heroe " << dañoEnemigo << "daño" << endl;

        //creamos otro if para comprobar la vida de nuestro heroe
        if (vidaHeroe <= 0) { //SI nuestro heroe tiene mayo igual a 0 queda fuera del juego
            cout << "El enemigo ha derrotado a nuestro heroe" << endl;
            break;
        }

    }

    return 0;
}


