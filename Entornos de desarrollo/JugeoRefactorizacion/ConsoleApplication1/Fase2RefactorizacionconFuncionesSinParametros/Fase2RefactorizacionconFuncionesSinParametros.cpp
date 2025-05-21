
//Ahora realizamos el codigo en funciones. Seguimos usando las variables goblales y valores fijos para los daños
#include <iostream>
using namespace std;

// Variables globales
int vidaHeroe = 100;
int vidaEnemigo = 100;
int ataqueHeroe = 20;
int ataqueEnemigo = 15;

// Declaración de funciones sin parametros
void heroAttackEnemy();
void enemyAttackHero();
void printStatus();

int main()
{
    cout << "¡Comienza el combate entre el héroe y el enemigo!" << endl;

    while (vidaHeroe > 0 && vidaEnemigo > 0) {
        heroAttackEnemy();
        if (vidaEnemigo <= 0) break;

        enemyAttackHero();
        if (vidaHeroe <= 0) break;

        printStatus();
    }

    return 0;
}

void heroAttackEnemy() {
    int daño = ataqueHeroe; // Daño fijo del héroe
    vidaEnemigo -= daño;
    cout << "El héroe ataca y causa " << daño << " de daño." << endl;
}

void enemyAttackHero() {
    int daño = ataqueEnemigo; // Daño fijo del enemigo
    vidaHeroe -= daño;
    cout << "El enemigo ataca y causa " << daño << " de daño." << endl;
}

void printStatus() {
    cout << "Vida del héroe: " << vidaHeroe << ", Vida del enemigo: " << vidaEnemigo << endl;
}


