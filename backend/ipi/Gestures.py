# -*- coding: utf-8 -*-
"""
Created on Sat Oct 27 10:58:32 2018

@author: Minkush
"""

import pandas as pd
import scipy.stats as st
import pickle
from sklearn import preprocessing 
data = pd.read_csv("Data.csv")
X = data.iloc[:,0:7].values
y = data.iloc[:,[7]].values
normalized_X = preprocessing.normalize(X)

from sklearn.model_selection import train_test_split
X_train,X_test,y_train,y_test = train_test_split(X,y,test_size = 0.20,random_state = 0) 


from sklearn.svm import SVC
obj = SVC(kernel = "rbf",random_state = 0)
obj.fit(X_train,y_train)

#y_pred = obj.predict(X_test)
with open("GesturesModel.txt",'wb') as fo:
    pickle.dump(obj,fo)

