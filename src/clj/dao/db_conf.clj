(ns clj.dao.db-conf
    (:require [monger.core :as mg]
              [monger.credentials :as mcr]))

(def dbuser "root")
(def dbpwd "example")
(def dbname "news")
(def dbhost "localhost")

(defn- build-conn-uri []
    (str "mongodb://" dbuser ":" dbpwd "@" dbhost "/" dbname))

(defn- get-conn-uri []
    (let [mongodb-uri (System/getenv "MONGODB_URI")]
        (if (empty? mongodb-uri)
            (build-conn-uri)
            mongodb-uri)))

(defn init-db
    []
    (def db/clojure-news (-> (get-conn-uri)
                             (mg/connect-via-uri)
                             :db)))