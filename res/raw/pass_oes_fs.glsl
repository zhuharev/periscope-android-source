#extension GL_OES_EGL_image_external : require
varying highp vec2 FS_UV;

uniform samplerExternalOES Texture0;
uniform highp float Random;

void main(void)
{
    // It's not clear why we need this keepAlive as it doesn't do anything, but without this, we've
    // seen reports where the camera preview freezes (on Nexus 5x). Setting one more param should
    // not change anything. The only possible explanation is there may be a bug in the OpenGL driver
    // where it's trying to be too smart, and looks at the sequence of draw commands over time and
    // thinks they're not changing when in fact the input textures are changing.
    highp float keepAlive = floor(Random * 0.00001); // == 0, does nothing
    lowp vec3 sample = texture2D(Texture0,  FS_UV.xy + vec2(keepAlive)).xyz;
    gl_FragColor = vec4(sample.xyz, 1.0);
}
