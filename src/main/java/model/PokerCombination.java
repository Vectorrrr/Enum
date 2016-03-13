package model;

import java.util.*;

/**
 * Created by CraZy_IVAN on 10.03.16.
 */
public enum PokerCombination {
    HEADCARD("Head Card", 0) {
        @Override
        public boolean isThisCombination(Hand hand) {
            Set<ValueCards> difCards = new HashSet<>();
            for (Card card : hand.getCards()) {
                difCards.add(card.getValueCards());
            }
            return difCards.size() == 5;
        }
    },
    PAIR("Pair", 100) {
        @Override
        public boolean isThisCombination(Hand hand) {
            List<Card> cards = hand.getCards();
            int countCards = cards.size();
            int ans = 0;
            for (int i = 0; i < countCards; ++i) {
                for (int j = i + 1; j < countCards; ++j) {
                    if (cards.get(i).getValueCards() == cards.get(j).getValueCards()) {
                        ans++;
                    }
                }
            }
            return ans == 1;
        }
    },
    TWOPAIR("Two Pair", 200) {
        @Override
        public boolean isThisCombination(Hand hand) {
            List<Card> cards = hand.getCards();
            int countCards = cards.size();
            int ans = 0;
            for (int i = 0; i < countCards; ++i) {
                for (int j = i + 1; j < countCards; ++j) {
                    if (cards.get(i).getValueCards().equals(cards.get(j).getValueCards())) {
                        ans++;
                    }
                }
            }
            return ans == 2;
        }
    },
    SET("Set", 300) {
        @Override
        public boolean isThisCombination(Hand hand) {
            List<Card> cards = hand.getCards();
            int countCards = cards.size();
            int ans = 0;
            for (int i = 0; i < countCards; ++i) {
                for (int j = i + 1; j < countCards; ++j) {
                    if (cards.get(i).getValueCards().equals(cards.get(j).getValueCards())) {
                        ans++;
                    }
                }
            }
            return ans == 3;
        }
    },
    STREET("Street", 400) {
        @Override
        public boolean isThisCombination(Hand hand) {
            Set<Integer> s = new HashSet<>();
            List<Card> cards = hand.getCards();
            int first = cards.get(0).getValueCards().getPoints();
            int ans = 0;
            for (int j = 1; j < cards.size(); ++j) {
                int t = Math.abs(first - cards.get(j).getValueCards().getPoints());
                s.add(t);
                ans += t;
            }
            return ans == 10 && s.size() == 5;
        }
    },
    FLUSH("Flush", 500) {
        @Override
        public boolean isThisCombination(Hand hand) {
            Set<SuitCards> set = new HashSet<>();
            for (Card card : hand.getCards()) {
                set.add(card.getSuitCards());
            }
            return set.size() == 1;
        }
    },
    FULLHAUSE("Full Hause", 600) {
        @Override
        public boolean isThisCombination(Hand hand) {
            List<Card> cards = hand.getCards();
            int countCards = cards.size();
            int ans = 0;
            for (int i = 0; i < countCards; ++i) {
                for (int j = i + 1; j < countCards; ++j) {
                    if (cards.get(i).getValueCards().equals(cards.get(j).getValueCards())) {
                        ans++;
                    }
                }
            }
            return ans == 4;
        }
    },
    SQUARE("Square", 700) {
        @Override
        public boolean isThisCombination(Hand hand) {
            List<Card> cards = hand.getCards();
            int countCards = cards.size();
            int ans = 0;
            for (int i = 0; i < countCards; ++i) {
                for (int j = i + 1; j < countCards; ++j) {
                    if (cards.get(i).getValueCards().equals(cards.get(j).getValueCards())) {
                        ans++;
                    }
                }
            }
            return ans == 6;
        }
    },
    STREETFLUSH("Street Flush", 800) {
        @Override
        public boolean isThisCombination(Hand hand) {
            return PokerCombination.FLUSH.isThisCombination(hand) &&
                    PokerCombination.STREET.isThisCombination(hand);
        }
    };

    private int point;
    private String name;


    PokerCombination(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isThisCombination(Hand hand);
}
