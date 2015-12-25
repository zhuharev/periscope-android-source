attribute vec4 Position;

uniform vec4 OffsetScale;
uniform float Rotation;
uniform float Mirror;

varying vec2 FS_UV;

void main(void)
{
	vec2 pos = (Position.xy * OffsetScale.zw + OffsetScale.xy);
	vec2 projPos = pos * vec2(2.0, -2.0) - vec2(1.0, -1.0);
	vec2 uv;
    if (Rotation == 90.0) {
        uv = vec2(Position.y, 1.0 - Position.x);
    } else if (Rotation == 180.0) {
        uv = vec2(1.0 - Position.x, 1.0 - Position.y);
    } else if (Rotation == 270.0) {
        uv = vec2(1.0 - Position.y, Position.x);
    } else {
        uv = vec2(Position.x, Position.y);
    }
    if (Mirror == 1.0) {
        uv.y = 1.0 - uv.y;
    }
    FS_UV = uv;
	gl_Position = vec4(projPos.xy, Position.z, Position.w);
}
