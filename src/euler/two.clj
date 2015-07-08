(ns euler.two)

(defn fibs
  [a b]
  (cons a (lazy-seq
           (fibs b (+ a b)))))

(defn -main
  []
  (->> (fibs 1 1)
       (take-while (fn [x] (< x 4000000)))
       (filter even?)
       (reduce +)
       (println)))
