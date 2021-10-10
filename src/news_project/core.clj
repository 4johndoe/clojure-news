(ns news-project.core
  (:require [ring.adapter.jetty :as jetty]
            [compojure.core :refer [defroutes GET ANY]]
            [compojure.route :refer [not-found resources]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.resource :as resource]
            [news-project.core.dao.db :as db]
            [news-project.core.route.user :as route-user]
            [clojure.java.io :as io]))

(defn log-middleware
  [handler]
  (fn [request]
    (println "Request path: " (:uri request))
    (handler request)))

(def handler (-> #'route-user/route
                log-middleware
                (resource/wrap-resource "/public")
                wrap-params))

(defn -main
  []
  (jetty/run-jetty #'handler {:port 8080}))
