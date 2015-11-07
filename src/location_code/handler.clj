(ns location-code.handler
  (:require [compojure.core :refer [defroutes GET]]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]]
            [location-code.codes :refer [county-codes
                                         municipality-codes
                                         congregation-codes]]))

(defn- location-response
  ([locations] (response {:success true
                          :data locations}))
  ([locations id] (let [location (locations id)]
                    (if location
                      (response {:success true
                                 :data location})
                      (response {:success false})))))

(defroutes app-routes
  (GET "/counties" []
       (location-response county-codes))
  (GET "/counties/:id" [id]
       (location-response county-codes id))
  (GET "/municipalities" []
       (location-response municipality-codes))
  (GET "/municipalities/:id" [id]
       (location-response municipality-codes id))
  (GET "/congregations" []
       (location-response congregation-codes))
  (GET "/congregations/:id" [id]
       (location-response congregation-codes id)))

(def app
  (-> app-routes
      (wrap-json-response)))
