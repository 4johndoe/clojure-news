(defproject news_project "0.1.0-SNAPSHOT"
  :description "Clojure News"
  :url "http://clojure.news"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies   [[org.clojure/clojure "1.10.3"]
                   [ring "1.9.4"]
                   [compojure "1.6.2"]]
  :main news-project.core

  :ring {:handler news-project.core/handler}
  )
