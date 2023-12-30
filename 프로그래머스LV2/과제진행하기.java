package 프로그래머스LV2;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class 과제진행하기 {

    class Solution {
        public String[] solution(String[][] plans) {
            ArrayList<String> results = new ArrayList<>();
            Stack<Plan> nextStack = new Stack<>();
            PriorityQueue<Plan> priorityQueue = new PriorityQueue<>();

            //priorityQueue 초기화
            for (String[] plan : plans) {
                priorityQueue.offer(new Plan(plan[0], plan[1], plan[2]));
            }

            int time = priorityQueue.peek().startTime;

            while(!priorityQueue.isEmpty()) {
                Plan nowPlan = priorityQueue.poll();

                if (priorityQueue.isEmpty()) {
                    results.add(nowPlan.homework);
                    break;
                }

                Plan nextPlan = priorityQueue.peek();

                if (nextPlan.startTime < time + nowPlan.needTime) {
                    nowPlan.needTime -= nextPlan.startTime - time;
                    nextStack.push(nowPlan);
                    time = nextPlan.startTime;
                }

                if (nextPlan.startTime == time + nowPlan.needTime) {
                    results.add(nowPlan.homework);
                    time = nextPlan.startTime;
                }

                if (nextPlan.startTime > time + nowPlan.needTime) {
                    results.add(nowPlan.homework);
                    time += nowPlan.needTime;

                    if (nextStack.isEmpty()) {
                        time = nextPlan.startTime;
                    }

                    while (!nextStack.isEmpty()) {
                        Plan remind = nextStack.pop();
                        if (remind.needTime <= (nextPlan.startTime - time)) {
                            results.add(remind.homework);
                            time += remind.needTime;
                            continue;
                        }

                        else {
                            remind.needTime -= (nextPlan.startTime - time);
                            nextStack.push(remind);
                            time = nextPlan.startTime;
                            break;
                        }
                    }
                    time = nextPlan.startTime;

                }
            }

            while (!nextStack.isEmpty()) {
                results.add(nextStack.pop().homework);
            }

            return results.toArray(new String[results.size()]);
        }

        class Plan implements Comparable<Plan>{
            String homework;
            int startTime;
            int needTime;

            Plan(String homework, String start, String neeTime) {
                this.homework = homework;
                this.startTime = makeTime(start);
                this.needTime = Integer.parseInt(neeTime);
            }

            private int makeTime(String t) {
                String[] parsed = t.split(":");
                int minutes = Integer.parseInt(parsed[1]);
                int hours = Integer.parseInt(parsed[0]) * 60;
                return minutes + hours;
            }

            @Override
            public int compareTo(Plan target) {
                return this.startTime >= target.startTime ? 1 : -1;
            }
        }
    }
}
