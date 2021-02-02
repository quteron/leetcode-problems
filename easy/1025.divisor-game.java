public boolean divisorGame(int N) {
    // 1. Base case when n=2, alice needs to be 1 and make bob lose the game
    // 2. When n is even, alice can chose odd factors and make it odd number to give
    // to bob.
    // 3. Odd numbers have odd factors and odd number - odd factor makes number even
    // 4. So, eventually alice will get number 2 and she wins
    return N % 2 == 0;
}
