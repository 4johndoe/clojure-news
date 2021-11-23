(ns clj.dao.db
    (:require   [monger.core :as mg]
                [monger.credentials :as mcr]))

;;TODO configured will be given by yaml
(defonce creds (mcr/create "root" "clojurenews" "example"))

(defonce conn (mg/connect-with-credentials "localhost" creds))

(defonce clojure-news (mg/get-db conn "clojurenews"))