//En esta fase, seguimos utilizando parámetros, pero cada función devuelve valores actualizados.
// Esto nos ayuda a mantener un flujo claro de datos sin modificar variables directamente dentro de las funciones.

#include <iostream>
using namespace std;

// Declaración de funciones
int heroAttackEnemy(int vidaEnemigo, int ataqueHeroe);
int enemyAttackHero(int vidaHeroe, int ataqueEnemigo);
void printStatus(int vidaHeroe, int vidaEnemigo);

int main()
{
    // Variables locales
    int vidaHeroe = 100;
    int vidaEnemigo = 100;
    int ataqueHeroe = 20;
    int ataqueEnemigo = 15;

    cout << "¡Comienza el combate entre el héroe y el enemigo!" << endl;

    while (vidaHeroe > 0 && vidaEnemigo > 0) {
        // El héroe ataca y se actualiza la vida del enemigo
        vidaEnemigo = heroAttackEnemy(vidaEnemigo, ataqueHeroe);
        if (vidaEnemigo <= 0) 
            break; // Si el enemigo pierde toda su vida, termina

        // El enemigo ataca y se actualiza la vida del héroe
        vidaHeroe = enemyAttackHero(vidaHeroe, ataqueEnemigo);
        if (vidaHeroe <= 0) 
            break; // Si el héroe pierde toda su vida, termina

        // Mostrar el estado actual
        printStatus(vidaHeroe, vidaEnemigo);
    }

    return 0;
}

// Función para calcular el ataque del héroe y devolver la nueva vida del enemigo
int heroAttackEnemy(int vidaEnemigo, int ataqueHeroe) {
    int daño = ataqueHeroe; // Daño fijo del héroe
    cout << "El héroe ataca y causa " << daño << " de daño." << endl;
    return vidaEnemigo - daño;
}

// Función para calcular el ataque del enemigo y devolver la nueva vida del héroe
int enemyAttackHero(int vidaHeroe, int ataqueEnemigo) {
    int daño = ataqueEnemigo; // Daño fijo del enemigo
    cout << "El enemigo ataca y causa " << daño << " de daño." << endl;
    return vidaHeroe - daño;
}

// Función para mostrar el estado actual del combate
void printStatus(int vidaHeroe, int vidaEnemigo) {
    cout << "Vida del héroe: " << vidaHeroe << ", Vida del enemigo: " << vidaEnemigo << endl;
}


//Explicación:
//Flujo de datos :
//Cada función devuelve el nuevo estado de vida del héroe o el enemigo después de calcular el daño.
//Estas vidas actualizadas se asignan a las variables correspondientes en main.
//Funciones :
    //heroAttackEnemy : Calcula el daño fijo que el héroe causa al enemigo y devuelve la nueva vida del enemigo.
    //enemyAttackHero : Calcula el daño fijo que el enemigo causa al héroe y devuelve la nueva vida del héroe.
    //printStatus : Solo muestra la información actual en pantalla, no modifica nada.
    //Ventaja : El programa es más modular y fácil de leer.