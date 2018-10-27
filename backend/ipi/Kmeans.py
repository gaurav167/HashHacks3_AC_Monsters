# -*- coding: utf-8 -*-
"""
Created on Sat Oct 27 01:43:05 2018

@author: Minkush and Mononito
"""

# K-Means Clustering

# Importing the libraries
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

# Importing the dataset
dataset = pd.read_excel('TransactionsData.xlsx')
X = dataset.iloc[:,1:8].values

# encoding
from sklearn.preprocessing import OneHotEncoder, LabelEncoder
labelencoder_X = LabelEncoder()
for i in range(7):
    X[:, i] = labelencoder_X.fit_transform(X[:, i])
onehotencoder = OneHotEncoder(categorical_features='all')
X = onehotencoder.fit_transform(X).toarray()
# Feature Scaling
from sklearn.preprocessing import StandardScaler
sc_X = StandardScaler()
X = sc_X.fit_transform(X)

# Using the elbow method to find the optimal number of clusters
from sklearn.cluster import KMeans
wcss = []
for i in range(1, 20):
    kmeans = KMeans(n_clusters = i, init = 'k-means++', random_state = 42)
    kmeans.fit(X)
    wcss.append(kmeans.inertia_)
plt.plot(range(1, 20), wcss)
plt.title('The Elbow Method')
plt.xlabel('Number of clusters')
plt.ylabel('WCSS')
plt.show()



# Fitting K-Means to the dataset
kmeans = KMeans(n_clusters = 30, init = 'k-means++', random_state = 42)
kmeans.fit(X)
