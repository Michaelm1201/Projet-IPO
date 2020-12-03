package infini;

import environment.Lane;
import environment.Car;
import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;
import util.Direction;

import java.util.ArrayList;

public class EnvInf implements IEnvironment {

        private ArrayList<Lane> roadLines;
        private Game game;

        public EnvInf(Game game){
            this.game = game;
            this.roadLines = new ArrayList<Lane>();
            this.roadLines.add(new Lane(game, 2, 0));  //première ligne

            for(int i=3; i< game.height; i++) {
                this.roadLines.add(new Lane(game, i, ((game.randomGen.nextInt(5)/100.0)+0.01)));  //densité aléatoire
            }
        }

    public void infini() {
            this.game.maxHeight+=1;
            this.roadLines.add(new Lane(game, game.defaultHeight, ((game.randomGen.nextInt(5)/100.0)+0.01)));
    }

    public void deplaceOrdCar(Direction d){
            for(Lane l :roadLines){
                l.deplaceOrdCar(d);
            }
            if(d == Direction.up){
                this.game.height+=1;

            }else{
                this.game.height-=1;
            }
    }


        /**
         * Teste si une case est sure, c'est � dire que la grenouille peut s'y poser
         * sans mourir
         *
         * @param c la case � tester
         * @return vrai s'il n'y a pas danger
         */
        //@Override
        public boolean isSafe(Case c, int compt) {
            return (this.roadLines.get(compt)).isSafe(c);
        }

       /**
         * Teste si la case est une case d'arrivee
         *
         * @param c
         * @return vrai si la case est une case de victoire
         */
        @Override
        public boolean isWinningPosition(Case c) {
            if(c.ord == game.height-1){
                return true;
            }else{
                return false;
            }
        }

        /**
         * Effectue une �tape d'actualisation de l'environnement
         */
        @Override
        public void update() {
            for(Lane l : this.roadLines){
                l.update();
            }


        }

}

