from blog.models import Post
from rest_framework import serializers

class PostSerializer(serializers.HyperlinkedModelSerializer):
    created_date = serializers.DateTimeField(format="%Y년%m월%d일\n%H시%M분")
    published_date = serializers.DateTimeField(format="%Y년%m월%d일\n%H시%M분")
    class Meta:
        model = Post
        fields = ('title', 'text', 'created_date', 'published_date', 'image')