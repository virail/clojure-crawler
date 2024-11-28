(ns crawler.core
  (:gen-class))

(defn extract-hrefs [html]
  (let [pattern #"<a[^>]*href=[\"']([^\"']*)[\"']"
        matches (re-seq pattern html)]
    (map second matches)))


;; Think we'll have it so its a cli kind of tool
;; We'll enter and be presented with a text of options
;; then execute
;; Present the results
;; then loop

;; GET THE UNICODE COLOURS AND STYLE FANCILY

;; temp look
;; Clojure-Crawler-CLI (Maybe in cool ascii)
;; Options:
;; 1. Crawl a website
;; 2. Crawl a website with a depth
;; 3. Crawl a website with a depth and a limit

;; Ok for now

(defn options []
  (println "Clojure-Crawler-CLI")
  (println "Options:")
  (println "1. Crawl a website")
  (println "2. Crawl a website with a depth")
  (println "3. Crawl a website with a depth and a limit"))

(defn crawl
  ([website]
   (println "Crawling website:" website)
   (println (extract-hrefs (slurp website))))
  ([website depth]
   (println "Crawling website:" website "with depth:" depth)
   ;; Implement depth-based crawling logic here
   )
  ([website depth limit]
   (println "Crawling website:" website "with depth:" depth "and limit:" limit)
   ;; Implement depth and limit-based crawling logic here
   ))

(defn execute-option 
  [option]
  (if (= option "1")
    (do (println "Enter website:")
        (flush)
        (let [website (read-line)]
          (do
            (println "Crawling website:" website)
            (println (extract-hrefs (slurp website))))))))

(defn -main
  [& args]
  (do (options)
      (execute-option (read-line))))
