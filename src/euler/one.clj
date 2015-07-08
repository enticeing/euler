(ns euler.one)

(defn threes-fives
  [x]
  (or (= (mod x 5) 0)
      (and (= (mod x 3) 0)
           (not (= (mod x 15) 0)))))

(defn -main
  []
  (def sum
    (reduce +
            (take-while (fn [x] (< x 1000))
                        (filter threes-fives (range)))))
  (println sum))
