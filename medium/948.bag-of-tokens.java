public int bagOfTokensScore(int[] tokens, int p) {
    int score=0;
    Arrays.sort(tokens);

    int l=0, r=tokens.length-1;
    while(l <= r) {
        if (tokens[l] <= p) {
            p -= tokens[l++];
            score++;
        } else if (score > 0 && l != r) {
            p += tokens[r--];
            score--;
        } else {
            break;
        }
    }

    return score;
}
