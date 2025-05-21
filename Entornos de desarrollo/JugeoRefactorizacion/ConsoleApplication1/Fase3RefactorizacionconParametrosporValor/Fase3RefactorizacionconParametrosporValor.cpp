//En esta etapa, eliminamos las variables globales y pasamos las variables como parámetros a las funciones.

#include <iostream>
using namespace std;

// Declaración de funciones
int heroAttackEnemy(int vidaEnemigo, int ataqueHeroe);
int enemyAttackHero(int vidaHeroe, int ataqueEnemigo);
void printStatus(int vidaHeroe, int vidaEnemigo);

int main()
{
    int vidaHeroe = 100;
    int vidaEnemigo = 100;
    int ataqueHeroe = 20;
    int ataqueEnemigo = 15;

    cout << "¡Comienza el combate entre el héroe y el enemigo!" << endl;

    while (vidaHeroe > 0 && vidaEnemigo > 0) {
        vidaEnemigo = heroAttackEnemy(vidaEnemigo, ataqueHeroe);
        if (vidaEnemigo <= 0) break;

        vidaHeroe = enemyAttackHero(vidaHeroe, ataqueEnemigo);
        if (vidaHeroe <= 0) break;

        printStatus(vidaHeroe, vidaEnemigo);
    }

    return 0;
}

int heroAttackEnemy(int vidaEnemigo, int ataqueHeroe) {
    int daño = ataqueHeroe; // Daño fijo del héroe
    cout << "El héroe ataca y causa " << daño << " de daño." << endl;
    return vidaEnemigo - daño;
}

int enemyAttackHero(int vidaHeroe, int ataqueEnemigo) {
    int daño = ataqueEnemigo; // Daño fijo del enemigo
    cout << "El enemigo ataca y causa " << daño << " de daño." << endl;
    return vidaHeroe - daño;
}

void printStatus(int vidaHeroe, int vidaEnemigo) {
    cout << "Vida del héroe: " << vidaHeroe << ", Vida del enemigo: " << vidaEnemigo << endl;
}

//1. Eliminamos las variables globales
//2. Cada funcion recibe como parametros las variables necesarias
//3. Usamos valores de retorno para actualizar las vidas depues de cada ataque
