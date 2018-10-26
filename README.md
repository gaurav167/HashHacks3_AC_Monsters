# Intelligent Payment Interface- Are you who you appear?

## Motivating the Problem
### The problem of Insider & Outsider threats 
With most consumers owning smartphone and mobile devices (91 percent), followed closely by laptop computers (83 percent), the digital marketplace is here now. As users embrace financial technology bringing banking and transactions to mobile users on the move, financial crimes are on a rise. Financial frauds can be classified into two classes:

- 'Outsider' threats- Threats by malicious third-party actors who do not have access to user credentials but bypasses the security of a system through its loop holes (cracking authentication).
- 'Insider' threats- Threats by actors (authorized users) who somehow have access to requisite user credentials (including traditional passwords).

Current payment interfaces provide security over outsider threats using traditional authentication mechanisms like 3-Factor Authentication, but fail to provide any effective countermeasure against insider threats. Also, many users tend to share passwords with their near and dear ones. In addition, many surveys suggest that traditional passwords are easily forgotten and do not provide a strong user experience and protection against outsider threats. 

As with outsider threats, insider incidents may be motivated by a range of different factors, including greed, revenge, stress, and espionage. However, the fact that 'insiders' might have access to user credentials makes insider threat detection extremely hard.  

### Where is the need?
- Automatic system essential, impossible for human analyst to detect fraudulent patterns in transaction datasets
- Users unreliable in reporting the loss of access credentials or fraudulent use
- Growing data theft, lesser effectiveness of traditional authentication methods
- How to design an intelligent system with the number of fraudulent transactions << legitimate transactions- unbalanced data distribution
- Desinging an intelligent transaction filter to identify financial losses


## Our Solution
This project implements an intelligent payment interface using Artificial Intelligence and Data Mining. 

Our solution authorizes users based on 'human peculiarities' as biometrics. In this respect we utilize mobile key stroke dynamics and adversarial gesture recognition to autheniticate users. These encompass both physiological and behavioral characteristics peculiar to human behavior. Research has shown that these methods have achieved considerable accuracy in authenitication [1].

Our system also creates a 'user DNA' using Sequential Pattern Mining to mine historical trends in genuine transactions committed by a user. It also applies an Euclidean-distance based outlier detection method to identify malicious transactions by intruders and preventing financial losses.   

## How does the payments interface look? 

<img src="https://user-images.githubusercontent.com/26150479/47592268-3efbaf80-d990-11e8-9894-0d9c0638c178.png">

## Dataset

<img src="https://user-images.githubusercontent.com/26150479/47592576-74ed6380-d991-11e8-91a6-f0d5bfc8cc41.png">

## Bibliography
- Global Fraud Report 2018- https://www.experian.com/assets/decision-analytics/reports/global-fraud-report-2018.pdf
- 1999, F. Monrose, A.D. Rubin, Keystroke Dynamics as Biometric for Authentication
- Steven Furnell, Enemies within: the problem of insider attacks
- Insider Threat Report 2018 Report, Cybersecurity Insiders


