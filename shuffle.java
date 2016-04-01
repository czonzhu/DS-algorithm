public void shuffleCards(Card[] cards){
    if(cards == null || cards.length == 0) return;
    Random r = new Random();
    for(int i = cards.length - 1; i >= 1; i--){
        swap(cards, i, r.nextInt(i + 1));
    }
}