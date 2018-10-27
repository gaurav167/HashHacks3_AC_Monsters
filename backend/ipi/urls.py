from django.conf.urls import url, include
from . import views

urlpatterns = [
	url(r'login/$', views.login_user, name="login"),
	url(r'pay/$', views.val_payment, name="validate_payment"),
	url(r'train/$', views.gen_typing_data),
]