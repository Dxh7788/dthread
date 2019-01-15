package com.dthread.part1.lesson13;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dongxiaohong
 * @date 2019/1/11 10:02
 */
public class JellyNonSync {
    public static void main(String[] args) {
        final JellyNonSync jellyNonSync = new JellyNonSync();
        final Lock lock = new ReentrantLock(true);
        Thread[] threads = new Thread[10];
        for (int i=0;i<10;i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    System.out.println(">>>>锁住....");
                    lock.unlock();
                }
            });
        }

        for (int i=0;i<10;i++) {
            threads[i].start();
        }
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                jellyNonSync.exec();
            }
        }).start();*/
    }

    /*public synchronized void exec(){
        lock.lock();
        System.out.println(">>>>锁住....");
        lock.unlock();
    }*/

    /*茕茕(qióng)孑(jié)立，沆(hàng)瀣(xiè)一气，踽踽(jǔ)独行，醍(tī)醐(hú)灌顶
    绵绵瓜瓞(dié)，奉为圭(guī)臬(niè)，龙行龘龘(dá)，犄(jī)角旮(gā)旯(lá)
    娉(pīng)婷袅(niǎo)娜(nuó)，涕(tī)泗(sì)滂(pāng)沱(tuó)
    呶呶(náo)不休，不稂(làng)不莠(yǒu)，卬(áng)
    咄(duō)嗟(jiē)蹀(dié)躞(xiè)耄(mào)耋(dié)饕(tāo)餮(tiè)
    囹(líng)圄(yǔ)蘡(yīng)薁(yù)觊(jì)觎(yú)龃(jǔ)龉(yǔ)
    狖(yòu)轭(è)鼯(wú)轩，怙(hù)恶不悛(quān)
    其靁(léi)虺虺(huī)，腌(ā)臢(zā)孑(jié)孓(jué)*/
}
