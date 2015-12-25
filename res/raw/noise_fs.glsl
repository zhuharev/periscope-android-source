#extension GL_OES_EGL_image_external : require
varying highp vec2 FS_UV;

uniform sampler2D Texture0;
uniform vec2 SampleOffset;
uniform vec2 SampleScale;

void main(void)
{
	lowp float n0 = texture2D(Texture0, (FS_UV.xy * SampleScale * 1.0) + SampleOffset).x;
	lowp float n1 = texture2D(Texture0, (FS_UV.xy * SampleScale * 0.5) + SampleOffset * 2.0).y;
	lowp vec3 n3 = texture2D(Texture0, (FS_UV.xy) + SampleOffset).xyz;
	lowp float n = sin((n0 + n1 + n3.x + n3.y + n3.z) * 10.0) * 0.5 + 0.5;
    gl_FragColor = vec4(n, n, n, 1.0);
}